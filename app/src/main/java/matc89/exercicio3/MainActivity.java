package matc89.exercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button buttonRemover;
    private Button buttonAdicionar;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private EditText editDescricao;
    private EditText editPrioridade;
    private ListView listView;
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private TarefaAdapter tarefaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRemover = (Button) findViewById(R.id.buttonRemover);
        buttonAdicionar = (Button) findViewById(R.id.buttonAdicionar);
        tarefaAdapter = new TarefaAdapter(this, tarefas);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editPrioridade = (EditText) findViewById(R.id.editPrioridade);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(tarefaAdapter);

        buttonRemover.setEnabled(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tarefas.remove(position);
                if (tarefas.size() == 0) buttonRemover.setEnabled(false);
                tarefaAdapter.notifyDataSetChanged();
            }
        });
    }
    public void remover1(View v){
        tarefas.remove(0);
        if(tarefas.size()==0){
            buttonRemover.setEnabled(false);
        }
        tarefaAdapter.notifyDataSetChanged();
    }

    public boolean checkIfPossible(String descricao, int prioridade){
        if(prioridade>10||prioridade<1){
            Toast toast = Toast.makeText(getApplicationContext(),"A prioridade deve estar entre 1 e 10.",
                    Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        for(Tarefa tarefa : tarefas){
            if(tarefa.getDescricao().equals(descricao)){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Tarefa já cadastrada.",
                        Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }
        }
        return true;
    }

    public void adicionar(View v){
        String descricao = editDescricao.getText().toString();
        int prioridade = Integer.parseInt(editPrioridade.getText().toString());
        if(checkIfPossible(descricao, prioridade)){
            Tarefa tarefa = new Tarefa(descricao,prioridade);
            tarefas.add(tarefa);
            Collections.sort(tarefas);
            tarefaAdapter.notifyDataSetChanged();
            buttonRemover.setEnabled(true);
            tarefaAdapter.notifyDataSetChanged();
        }
    }

}
