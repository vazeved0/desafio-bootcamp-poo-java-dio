package br.com.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosIscritos = new LinkedHashSet<>();
    private Set<Conteudo> getConteudosConcluidos = new LinkedHashSet<>();

    public void increverBootcamp(Bootcamp bootcamp){
        this.conteudosIscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsIncritos().add(this);
    }

    public void progredir (){
        Optional<Conteudo> conteudo = this.conteudosIscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.getConteudosConcluidos.add(conteudo.get());
            this.conteudosIscritos.remove(conteudo.get());
        }else{
            System.err.println("Você não esta matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp(){
        return this.getConteudosConcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularXp())
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIscritos() {
        return conteudosIscritos;
    }

    public void setConteudosIscritos(Set<Conteudo> conteudosIscritos) {
        this.conteudosIscritos = conteudosIscritos;
    }

    public Set<Conteudo> getGetConteudosConcluidos() {
        return getConteudosConcluidos;
    }

    public void setGetConteudosConcluidos(Set<Conteudo> getConteudosConcluidos) {
        this.getConteudosConcluidos = getConteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosIscritos, dev.conteudosIscritos) && Objects.equals(getConteudosConcluidos, dev.getConteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosIscritos, getConteudosConcluidos);
    }
}
