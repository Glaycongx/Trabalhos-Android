package com.senai.tarefas.adapter;

import java.util.List;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.senai.listadetarefas.modelo.Tarefa;
import com.senai.listadetarefas.R;

public class TarefaAdapter extends BaseAdapter {

	private List<Tarefa> listaTarefas;
	private LayoutInflater inflater;

	public TarefaAdapter(Context context, List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void addItem(Tarefa tarefa) {
		this.listaTarefas.add(tarefa);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return listaTarefas.size();
	}

	@Override
	public Object getItem(int position) {
		return listaTarefas.get(position);

	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Tarefa tarefa = listaTarefas.get(position);
		convertView = inflater.inflate(R.layout.item_tarefa, null);
		
		TextView tvTarefa = (TextView)convertView.findViewById(R.id.tx_tarefa);
		tvTarefa.setText(tarefa.getTarefa());
		
		TextView tvCategoria = (TextView)convertView.findViewById(R.id.tx_categoria);
		tvCategoria.setText(tarefa.getCategoria());
		
		TextView tvData = (TextView)convertView.findViewById(R.id.tx_data);
		tvData.setText(tarefa.getDataConclusao());
		
		ImageView ivPrioridade = (ImageView)convertView.findViewById(R.id.iv_prioridade);
		if ("baixa".equals(tarefa.getPrioridade().toLowerCase())) {
			ivPrioridade.setImageResource(R.drawable.ic_baixa);
		}	else if ("media".equals(tarefa.getPrioridade().toLowerCase()))	{
			ivPrioridade.setImageResource(R.drawable.ic_media);
			}else if ("alta".equals(tarefa.getPrioridade().toLowerCase()))	{
				ivPrioridade.setImageResource(R.drawable.ic_alta);
			}
		
		CheckBox cbConcluido = (CheckBox)convertView.findViewById(R.id.cb_concluido);
		cbConcluido.setChecked(tarefa.getConcluido());
		
		
		return convertView;
	}

}
