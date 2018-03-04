/*Intent intent = getIntent();
				ArrayList<String> listaTarefaAuxiliar = intent.getStringArrayListExtra("listaTarefa");
				if (listaTarefaAuxiliar != null) {
				listaTarefa = listaTarefaAuxiliar;*/
package com.senai.listadetarefas;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.senai.dao.TarefaDao;
import com.senai.listadetarefas.modelo.Tarefa;

public class CadastroActivity extends Activity {

	private int ano,mes,dia;
	private Button data;
	private TarefaDao tarefaDao;
	private Tarefa tarefa;
	ArrayList<String> listaTarefa = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_tarefa);
		
		tarefaDao = new TarefaDao(this);
		
		
		
		// Buscar data do aparelho
				Calendar calendar = Calendar.getInstance();
				//E define o resultado nas variaveis 
				ano = calendar.get(Calendar.YEAR);
				mes = calendar.get(Calendar.MONTH);
				dia = calendar.get(Calendar.DAY_OF_MONTH);
				//e aqui define o texto do botão com as datas .. 
				//obs: Mes+1 .. o mes está retornando um anterior
				data = (Button) findViewById(R.id.bt_date);
				data.setText(dia + "/" + (mes+1) + "/" + ano);
				
						}
	

	public void selecionarData(View view) {
		// Quando metodo chamado ele executa o onCreateDialog
		showDialog(view.getId());
	}
	//função que é executada para exibir a caixa de data
	protected Dialog onCreateDialog(int id) {
		//Verifica se o id  da view e o mesmo do botao
		if(R.id.bt_date == id){
			//Retorna uma nova caixa de dialogo para as datas
		return new DatePickerDialog(this, Listener, ano, mes, dia);	
			
		}
		//se não retorna nulo mesmo
		return null;
		
	}

	// Listener e o responsavel para tratar as datas escolhidas pelo usuario 
	private OnDateSetListener Listener = new OnDateSetListener() {
		
		//metodo dateset para setar as datas escolhidas nas variaveis que são exibidas no botao
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// metodo para setar as datas 
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
			//Note que é mes +1 .. motivo não sei kkk'
			data.setText(dia + "/" + (mes+1) + "/" + ano);
		}
	}; 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_tarefa, menu);
		return true;
	}
	
	private void cancelar() {
		mostrarListagem();

	}
	
	public void cancelar(View view) {
		cancelar();
	}
	
	private void mostrarListagem() {
		Intent intent = new Intent(this, ListagemActivity.class);
		/*intent.putStringArrayListExtra("listaTarefa", listaTarefa);*/
		startActivity(intent);

	}
	
	public void salvar(View view) {
		capturarDados();
		Tarefa id = tarefaDao.salvar(this.tarefa);
		mostrarMensagem("A tarefa salva tem o id = " + id);
		//mostrarListagem();
//		mostrarMensagem(tarefa.toString());
	}
	
	/*private void adicionarTarefa(String tarefa) {
		listaTarefa.add(tarefa);
	}*/
	
	public void mostrarMensagem(String m) {
		Toast.makeText(this, m, Toast.LENGTH_LONG).show();
	}
	
	private void capturarDados() {
		tarefa = new Tarefa();
		
		EditText etTarefa = (EditText)findViewById(R.id.et_tarefa);
		tarefa.setTarefa(etTarefa.getText().toString());
		
		EditText etCategoria = (EditText)findViewById(R.id.et_categoria);
		tarefa.setCategoria(etCategoria.getText().toString());
		
		Button etDataConclusao = data;
		tarefa.setDataConclusao(etDataConclusao.getText().toString());
		
		RadioGroup rgPrioridade = (RadioGroup)findViewById(R.id.rg_prioridade);
		tarefa.setPrioridade(((RadioButton)findViewById(rgPrioridade.getCheckedRadioButtonId())).getText().toString());
		
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.acao_cancelar) {
			cancelar();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
