package com.senai.trekking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContadorActivity extends Activity {

	private Integer passos = 0;
	private Integer resultado = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contador);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
	}
	
	public void contagemProgressiva(View view) {
		this.passos++;
		this.resultado++;
		mostrarPassos();

	}
	
	public void Zerar(View view) {
		this.passos = 0;
		mostrarPassos();
	}
	
	private void mostrarPassos() {
		Button btContador = (Button)findViewById(R.id.bt_contador);
		btContador.setText(String.valueOf(this.passos));
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contador, menu);
		return true;
	}

	

	private void novaTarefa() {
		Intent i = new Intent(this, DecrementoActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	private void novaTarefa1() {
		Intent i = new Intent(this, TotalActivity.class);
		i.putExtra("resultado", this.resultado);
		startActivity(i);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId(),id1 = item.getItemId();;
		if (id == R.id.acao_decremento) {
			novaTarefa();
			return true;
		}
		 
		else if (id1 == R.id.acao_total1) {
				novaTarefa1();
				return true;
		}
		
		return super.onOptionsItemSelected(item);
	
	}
}
