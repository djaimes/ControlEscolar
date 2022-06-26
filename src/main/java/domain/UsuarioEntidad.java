/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package domain;

import java.sql.Date;

/**
 *
 * @author dajaimes
 */
public class UsuarioEntidad {
    int id;
    String login;
    String password;
    String nombre;
    String paterno;
    String materno;
    String sexo;
    String correo;
    String codigo;
    int activo;
    int perfil;
    Date alta;

    public UsuarioEntidad(int id, String login, String password, String nombre, String paterno, String materno, String sexo, String correo, String codigo, int activo, int perfil, Date alta) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.sexo = sexo;
        this.correo = correo;
        this.codigo = codigo;
        this.activo = activo;
        this.perfil = perfil;
        this.alta = alta;
    }

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "UsuarioEntidad{" + "id=" + id + ", login=" + login + ", password=" + password + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", sexo=" + sexo + ", correo=" + correo + ", codigo=" + codigo + ", activo=" + activo + ", perfil=" + perfil + ", alta=" + alta + '}';
    }
}
