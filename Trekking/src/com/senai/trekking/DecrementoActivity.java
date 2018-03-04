package com.senai.trekking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DecrementoActivity extends Activity {

	private Integer passos = 0;
	private Integer limite = 0;
	private Integer resultado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decremento);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
	}
	
	public void contagemRegressiva(View view) {
		if (this.limite == 0) {
			capturaLimite();
		}
		if (this.passos > 0) {
			this.passos--;
			this.resultado++;
			mostrarPassos(); 
		}
	}
	public void reiniciar(View view) {
		capturaLimite();
		mostrarPassos();
	}
	
	private void mostrarPassos() {
		Button btDecremento = (Button)findViewById(R.id.bt_decremento);
		btDecremento.setText(this.passos.toString());
	}
	
	private void capturaLimite() {

		EditText et_limite = (EditText)findViewById(R.id.et_limite);
		String stringlimite = et_limite.getText().toString();
		stringlimite = "".equals(stringlimite) ? "0" : stringlimite;
		this.limite = Integer.parseInt(stringlimite);
		this.passos = this.limite;
		
	}
	
	private void novaTarefa() {
		Intent i = new Intent(this, ContadorActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	private void novaTarefa1() {
		Intent i = new Intent(this, TotalActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.decremento, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId(),id1 = item.getItemId();;
		if (id == R.id.acao_incremento) {
			novaTarefa();
			return true;
		}
		 
		else if (id1 == R.id.acao_total) {
				novaTarefa1();
				return true;
		}
		
		return super.onOptionsItemSelected(item);
	
	}
}
