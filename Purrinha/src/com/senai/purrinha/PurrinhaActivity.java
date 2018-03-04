package com.senai.purrinha;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PurrinhaActivity extends Activity {
	private int num =0,total=0,num_pc=0,total_pc=0;
	private String resultado;
	private EditText et_voce,et_total;
	private EditText et_total1,et_voce1,et_pc,et_pctotal;
	private TextView tx_resultado;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_purrinha);
		
		
		// Captura dos Edit text
		et_voce = (EditText) findViewById(R.id.et_voce);
		et_total = (EditText) findViewById(R.id.et_total);
		
		et_voce1 = (EditText) findViewById(R.id.et_voce1);
		et_total1 = (EditText) findViewById(R.id.et_total1);
		et_pc = (EditText) findViewById(R.id.et_pc);
		et_pctotal = (EditText) findViewById(R.id.et_pctotal);
		tx_resultado = (TextView) findViewById(R.id.tx_resultado);
	}
	
	public void vai(View v) {
		resultado ="";
		capturarRandom();
	}
	
		@SuppressLint("ShowToast")
		private void capturarRandom() {
			//Gerador de numero randomico 
			num_pc =  new Random().nextInt(4);
			if(num_pc == 0){
			total_pc = new Random().nextInt(4);
			}
			else if(num_pc == 1){
				total_pc = new Random().nextInt(5);
				}
			else if(num_pc == 2){
				total_pc = new Random().nextInt(6);
				}
			else if(num_pc == 3){
				total_pc = new Random().nextInt(7);
				}
			
			num = Integer.parseInt(et_voce.getText().toString());
			total = Integer.parseInt(et_total.getText().toString());
			//Condições para verificar se numeros iguais e etc
			while(num > total || num < 0 || num >3 || total >6){
				
				et_voce.setText("");
				et_total.setText("");
				num = 0;
				total = 0;
				Toast.makeText(this,"Número Invalido",Toast.LENGTH_LONG).show();
			
			}
			
			while(num_pc == num || total_pc < num_pc || total == total_pc ) {
				num_pc =  new Random().nextInt(4);
				if(num_pc == 0){
					total_pc = new Random().nextInt(4);
					}
					else if(num_pc == 1){
						total_pc = new Random().nextInt(5);
						}
					else if(num_pc == 2){
						total_pc = new Random().nextInt(6);
						}
					else if(num_pc == 3){
						total_pc = new Random().nextInt(7);
						}
				et_voce1.setText("" + num);
				et_total1.setText("" + total);
				et_pc.setText("" + num_pc);
				et_pctotal.setText(""+ total_pc);
				
			}
			
			et_voce1.setText("" + num);
			et_total1.setText("" + total);
			et_pc.setText("" + num_pc);
			et_pctotal.setText(""+ total_pc);
			
			
			//Condição de verificação de vitória 
			//num é o numero do usuario , e total é total do usario
			//num_pc é numero da maquina , e total_pc e total da maquina
			
			
			if (num + num_pc == total && num + num_pc == total_pc){
				resultado = "Empate";
				tx_resultado.setTextColor(Color.GRAY);
			}
			else if(num + num_pc == total){
				resultado = "Você Venceu";
				tx_resultado.setTextColor(Color.GREEN);
			}
			else if(num + num_pc == total_pc){
				resultado = "Você Perdeu";
				tx_resultado.setTextColor(Color.RED);
			}
			else if(num + num_pc != total && num + num_pc != total_pc) {
				resultado = "Empate";
				tx_resultado.setTextColor(Color.GRAY);
			}
			tx_resultado.setText(resultado);
		
			et_voce.setText("");
			et_total.setText("");
			
	}
	
		public void novoJogo(View view) {
			
			Intent intent = new Intent(this, PurrinhaActivity.class);
			startActivity(intent);
		}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.purrinha, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
