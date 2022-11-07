package com.pestanias.pestanias.model;

public class UsuarioJSON {

    private String title,first, last,large,email,phone;

    public UsuarioJSON(String title, String first, String last, String large, String email, String phone) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.large = large;
        this.email = email;
        this.phone = phone;
    }

    public void mostrarDatos(){
        System.out.println("title: " + title);
        System.out.println("nombre: " +first);
        System.out.println("apellido: " +last);
        System.out.println("imagen: " +large);
        System.out.println("email: " +email);
        System.out.println("numero: " +phone);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",title,first,last);
    }
}
