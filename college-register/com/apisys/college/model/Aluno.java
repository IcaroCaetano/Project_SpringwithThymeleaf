/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apisys.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Simple Person.
 *
 * @author ICARO
 */
@Entity
@Table(name = "curso")
public class Aluno extends NamedEntity {

    public enum Status { MATRICULADO, TRANCADO, JUBILADO }

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "status")
    private Status status;

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
