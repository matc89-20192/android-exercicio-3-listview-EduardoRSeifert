package matc89.exercicio3;

import android.support.annotation.NonNull;

import java.util.Collections;

public class Tarefa implements Comparable{
    private String descricao;
    private int prioridade;

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return prioridade - ((Tarefa)o).getPrioridade();
    }

}
