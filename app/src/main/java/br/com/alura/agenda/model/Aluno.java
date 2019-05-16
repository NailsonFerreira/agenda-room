package br.com.alura.agenda.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    private String sobrenome;
    private String telefoneCelular;
    private String telefoneFixo;

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    private String email;
    private Calendar momentoCadastro = Calendar.getInstance();




    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMomentoCadastro(Calendar momentoCadastro) {
        this.momentoCadastro = momentoCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getMomentoCadastro() {
        return momentoCadastro;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + telefoneCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }

    public String getNomeCompleto(){
        return nome + " " + sobrenome;
    }

    public String dataFormatada(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(momentoCadastro.getTime());
    }
}
