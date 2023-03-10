package com.aurora.ekurban.domain;

import javax.persistence.*;

/**
 * Sisteme giriş yapacak olan kullanıcı bilgisini tutan User sınıfı
 */
@Table(name = "Users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * kullanıcı girişi için kullanıacak olan mail bilgisi
     */
    private String eposta;

    /**
     * kullanıcı girişi için kullanıacak olan şifre bilgisi
     */
    private String sifre;

    public User() {
    }

    public User(String eposta, String sifre) {
        this.eposta = eposta;
        this.sifre = sifre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
