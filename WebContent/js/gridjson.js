Ext.onReady(function(){

   //data store que l� os dados vindos do json
   //experimente substituir contatojson.jsp por contatos.json - ter� o mesmo efeito
    var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy(
			new Ext.data.Connection({
				url:'contatojson.jsp'
			})
		),
		reader:new Ext.data.JsonReader({
			totalProperty:'total',
			root:'rows',
			fields: [
			          'nome',
			          'telefone',
			          'email',
			          {name: 'aniversario', type: 'date', dateFormat: 'd/m/Y'}           
			        ]
		})
	});


    // cria o grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "NOME", width: 170, sortable: true, dataIndex: 'nome'},
            {header: "TELEFONE", width: 150, sortable: true, dataIndex: 'telefone'},
            {header: "EMAIL", width: 150, sortable: true, dataIndex: 'email'},
            {header: "DATA NASC.", width: 100, sortable: true, dataIndex: 'aniversario',
            	renderer: Ext.util.Format.dateRenderer('d/m/Y')}
        ],
        title: 'Grid com Json - Extjs',
        height:230,
        width:590,
		renderTo: document.body,
		frame:true
    });
    
   //l� os dados
    store.load();

    //div do grid
    grid.render('grid-json');
});