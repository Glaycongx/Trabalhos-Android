package com.senai.jokenpo;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Jokenpo extends Activity {
	
	private String voce, pc_obj, resultado;
	private TextView tv_resultado, tv_voce, tv_pc;
	private int pc;
	private Integer inicio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);
		
		if(inicio == 0 ){
        AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Jokenpo.this);
        CaixaAlerta.setTitle("ATENÇÃO");
        CaixaAlerta.setMessage("Esta versão do jogo é a versão Early Access."
        		+ "Você vai notar erros, falhas, etc, isso é normal."
        		+ "Não deixe de nos enviar seu feedback ,sua opinião é muito importante ! "
        		+ "Obrigado por jogar e se divertir!");
        CaixaAlerta.setNeutralButton("OK", null);
        CaixaAlerta.show();
        inicio = inicio ++;
		}
		Log.w("id", inicio.toString());
       
        
//        tv_voce = (TextView) findViewById(R.id.iv_voce);
//        tv_pc = (TextView) findViewById(R.id.iv_pc);
        tv_resultado = (TextView) findViewById(R.id.tx_resultado);
        
    }
    
    public void novoJogo(View view) {
		Intent intent = new Intent(this, Jokenpo.class);
		
		startActivity(intent);
//		mostrarMensagem();

	}
    
    public void jogarPedra(View view) {
    	voce ="pedra";
    	resultado = "";
    	capturarRandom();
//		mostrarMensagem();
	}
    
    public void jogarPapel(View view) {
    	voce = "papel";
    	resultado = "";
    	capturarRandom();
//		mostrarMensagem();
	}
    
    public void jogarTesoura(View view) {
    	voce = "tesoura";
    	resultado = "";
    	capturarRandom();
//		mostrarMensagem();
	}
    
        
//    private void mostrarMensagem() {
//    	String m;
//    		m = "O botão foi clicado";
//    		Toast.makeText(this, m.toString(), Toast.LENGTH_LONG).show();
//	}
    
    @SuppressLint("ShowToast")
    
    private void capturarRandom() {
    	    	
    	//gerar Random
		pc = new Random().nextInt(3);
		if(pc == 0){
			pc_obj = "pedra";
		}
		if(pc == 1){
			pc_obj = "papel";
		}
		if(pc == 2){
			pc_obj = "tesoura";
		}
		
		
//		tv_voce.setText(voce);
//		tv_pc.setText(pc_obj);
		
		// mandar icon para versus
		
		if(voce == "pedra"){
			ImageView iv_pedra = (ImageView) findViewById(R.id.iv_voce1);
			iv_pedra.setImageResource(R.drawable.ic_pedra);
		} else if (voce == "papel") {
			ImageView iv_papel = (ImageView) findViewById(R.id.iv_voce1);
			iv_papel.setImageResource(R.drawable.ic_papel);
		} else if (voce == "tesoura"){
			ImageView iv_tesoura = (ImageView) findViewById(R.id.iv_voce1);
			iv_tesoura.setImageResource(R.drawable.ic_tesoura);
		}
		
		if(pc_obj == "pedra"){
			ImageView iv_pedra = (ImageView) findViewById(R.id.iv_pc);
			iv_pedra.setImageResource(R.drawable.ic_pedra);
		} else if (pc_obj == "papel") {
			ImageView iv_papel = (ImageView) findViewById(R.id.iv_pc);
			iv_papel.setImageResource(R.drawable.ic_papel);
		} else if (pc_obj == "tesoura"){
			ImageView iv_tesoura = (ImageView) findViewById(R.id.iv_pc);
			iv_tesoura.setImageResource(R.drawable.ic_tesoura);
		}
		
		//resultados
		
		if(voce == pc_obj){
			resultado = "Empate";
			tv_resultado.setTextColor(Color.GRAY);
		}
		else if(voce == "pedra" && pc_obj == "tesoura"){
			resultado = "Você Venceu! :D";
			tv_resultado.setTextColor(Color.GREEN);
		}
		else if(voce == "tesoura" && pc_obj == "papel"){
			resultado = "Você Venceu! :D";
			tv_resultado.setTextColor(Color.GREEN);
		}
		else if(voce == "papel" && pc_obj == "pedra"){
			resultado = "Você Venceu! :D";
			tv_resultado.setTextColor(Color.GREEN);
		}
		else if(voce == "papel" && pc_obj == "tesoura"){
			resultado = "Você Perdeu! :(";
			tv_resultado.setTextColor(Color.RED);
		}
		else if(voce == "pedra" && pc_obj == "papel"){
			resultado = "Você Perdeu! :(";
			tv_resultado.setTextColor(Color.RED);
		}
		else if(voce == "tesoura" && pc_obj == "pedra"){
			resultado = "Você Perdeu! :(";
			tv_resultado.setTextColor(Color.RED);
		}
		tv_resultado.setText(resultado);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jokenpo, menu);
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