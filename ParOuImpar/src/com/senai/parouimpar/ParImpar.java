package com.senai.parouimpar;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ParImpar extends Activity {
	private EditText et_num;
	private TextView tv_resultado, et_vc, et_pc;
	private int num, num_pc, tot;
	private String opc, res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_par_impar);

		et_num = (EditText) findViewById(R.id.et_numero);
		et_pc = (TextView) findViewById(R.id.tx_pc);
		et_vc = (TextView) findViewById(R.id.tx_voce);
		tv_resultado = (TextView) findViewById(R.id.tx_resultado);
	}

	public void par(View v) {
		opc = "par";
		resultado();
	}

	public void impar(View v) {
		opc = "impar";
		resultado();
	}

	public void random() {
		num_pc = new Random().nextInt(5);
	}

	public void resultado() {
		random();
		num = Integer.parseInt(et_num.getText().toString());

		tot = num + num_pc;
		et_pc.setText("" + num_pc);
		et_vc.setText("" + num);

		if (tot % 2 == 0 && opc == "par") {
			res = "Você venceu";
			tv_resultado.setTextColor(Color.GREEN);
		} else if (tot % 2 != 0 && opc == "impar") {
			res = "Você venceu";
			tv_resultado.setTextColor(Color.GREEN);
		} else {
			res = "Você perdeu";
			tv_resultado.setTextColor(Color.RED);
		}
		tv_resultado.setText(res);
	}

	public void novoJogo(View view) {
		Intent intent = new Intent(this, ParImpar.class);

		startActivity(intent);
		// mostrarMensagem();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.par_impar, menu);
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
