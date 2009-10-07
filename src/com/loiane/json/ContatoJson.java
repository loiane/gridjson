package com.loiane.json;

import java.util.List;

import net.sf.json.JSONArray;

import com.loiane.json.utils.GeradorContatos;

/**
 * Classe responsável por transformar objetos java em JSON
 * @author Loiane Groner
 *
 */
public class ContatoJson {

	/**
	 * Retorna um objeto JSON utilizado para popular o data.Store do Ext JS
	 * no seguinte formato:
	 * {total:8,
	 *	rows:[
	 * 		{"telefone":"11-12345678","email":"maria@provedor.com","nome":"Maria","aniversario":"01/03/1984"},
	 * 		{"telefone":"12-55698745","email":"pedro@provedor.com","nome":"Pedro","aniversario":"12/05/1983"},
	 * 		{"telefone":"21-78542359","email":"joao@provedor.com","nome":"João","aniversario":"23/06/1983"},
	 * 		{"telefone":"27-25854567","email":"tiago@provedor.com","nome":"Tiago","aniversario":"07/02/1982"},
	 * 		{"telefone":"33-31595187","email":"carla@provedor.com","nome":"Carla","aniversario":"30/11/1984"},
	 * 		{"telefone":"21-98652938","email":"estela@provedor.com","nome":"Estela","aniversario":"29/07/1985"},
	 * 		{"telefone":"71-87241548","email":"lucas@provedor.com","nome":"Lucas","aniversario":"25/12/1984"},
	 * 		{"telefone":"85-33984526","email":"mariana@provedor.com","nome":"Mariana","aniversario":"02/01/1984"}
	 * 	]
	 * }
	 * @return lista de contatos em formato JSON
	 */
	public String getJson(){

		//gera os contatos
		List<Contato> contatos = GeradorContatos.geraContatos();

		//transforma a lista de Contatos em formato JSON
		JSONArray jsonArray = JSONArray.fromObject(contatos);

		//cria a estrutura do objeto necessário para popular o data.Store do Ext JS
		String returnJson = "{total:"+contatos.size()+",rows:"+jsonArray+"}";

		return returnJson;
	}

}
