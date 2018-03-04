package com.senai.trekking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TotalActivity extends Activity {

	

private Integer resultado = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_total);
		Intent intent = getIntent();
		this.resultado = intent.getIntExtra("resultado", 0);
		mostrarResultado();
	}
	
	private void mostrarResultado() {
		TextView tvResultado = (TextView)findViewById(R.id.tv_resultado);
		tvResultado.setText(this.resultado.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.total, menu);
		return true;
	}
	
	
	private void novaTarefa() {
		Intent intent = new Intent(this, ContadorActivity.class);
		startActivity(intent);}
	
	private void novaTarefa1() {
		Intent intent = new Intent(this, DecrementoActivity.class);
		startActivity(intent);}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId(),id1 = item.getItemId();;
		if (id == R.id.acao_progressivo) {
			novaTarefa();
			return true;
		}
		 
		else if (id1 == R.id.acao_regressivo) {
				novaTarefa1();
				return true;
		}
		
		return super.onOptionsItemSelected(item);
	
	}
}
