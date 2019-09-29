package matc89.exercicio3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dudas on 28/09/2019.
 */

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private ArrayList<Tarefa> tarefas;

    private static class ViewHolder{
        private TextView descricao;
        private TextView prioridade;
    }

    public TarefaAdapter(Context context,ArrayList<Tarefa> tarefas){
        super(context, 0, tarefas);
        this.tarefas = tarefas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(android.R.layout.simple_list_item_2, parent, false);

            holder = new ViewHolder();
            holder.descricao = (TextView) convertView.findViewById(android.R.id.text1);
            holder.prioridade = (TextView) convertView.findViewById(android.R.id.text2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Tarefa item = getItem(position);

        if (item!= null) {
            holder.descricao.setText(String.format("%s", item.getDescricao()));
            holder.prioridade.setText(String.format("Prioridade: %d", item.getPrioridade()));
        }

        return convertView;
    }
}
