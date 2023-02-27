import br.com.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso javascript");
        curso2.setDescricao("descrição curso javascript");
        curso2.setCargaHoraria(5);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("mentoria java");
        mentoria1.setDescricao("descrição mentoria java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("mentoria javascript");
        mentoria2.setDescricao("descrição mentoria javascript");
        mentoria2.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescrição("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Vinicius");
        dev1.increverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos " +dev1.getNome() + dev1.getConteudosIscritos());
        dev1.progredir();
        System.out.println("Conteúdos Concluidos " +dev1.getNome() + dev1.getGetConteudosConcluidos());
        System.out.println("XP:"+dev1.calcularTotalXp());


        System.out.println("--------------------------");


        Dev dev2 = new Dev();
        dev2.setNome("João");
        dev2.increverBootcamp(bootcamp);
        System.out.println("Conteúdos Incritos " +dev2.getNome()+ dev2.getConteudosIscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("Conteúdos Concluidos " +dev2.getNome()+ dev2.getGetConteudosConcluidos());
        System.out.println("XP:"+dev2.calcularTotalXp());
    }
}