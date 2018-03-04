package com.senai.listadetarefas;

import java.util.ArrayList;
import java.util.Arrays;

import com.senai.dao.TarefaDao;
import com.senai.listadetarefas.R;
import com.senai.listadetarefas.R.id;
import com.senai.listadetarefas.R.layout;
import com.senai.listadetarefas.R.menu;
import com.senai.listadetarefas.modelo.Tarefa;
import com.senai.tarefas.adapter.TarefaAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ListagemActivity extends ListActivity {
	
	private ArrayList<Tarefa> listaTarefa = new ArrayList<Tarefa>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.activity_listagem);
	
	ListView list = (ListView)getListView();
	
	/*listaTarefa.add(new Tarefa(1, "Comprar biscoito", "Irmão", "26/08/2015", "Alta", Boolean.FALSE));
	listaTarefa.add(new Tarefa(2, "Comprar leite", "Mamãe", "27/08/2015", "Media", Boolean.TRUE));
	listaTarefa.add(new Tarefa(3, "Comprar carro", "Papai", "25/12/2015", "Alta", Boolean.TRUE));
	listaTarefa.add(new Tarefa(4, "Comprar ovos", "Mamãe", "25/10/2015", "Media", Boolean.FALSE));
*/	
	TarefaDao dao = new TarefaDao(this);
	listaTarefa = dao.buscarTodos();
	
	
	TarefaAdapter adapter = new TarefaAdapter(this, listaTarefa);
	list.setAdapter(adapter);
	
	}
	
	 	
	private void novaTarefa() {
		Intent intent = new Intent(this, CadastroActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listagem, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.acao_cadastrar) {
			novaTarefa();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
