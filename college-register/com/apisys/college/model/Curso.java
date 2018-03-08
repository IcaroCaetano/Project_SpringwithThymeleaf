package com.apisys.college.model;
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple Course.
 *
 * @author ICARO
 */
@Entity
@Table(name = "curso")
public class Curso extends NamedEntity {

    @Column(name = "codigo_curso")
    private String codigo; 
   
    @Column(name = "instiuicao_ensino")
    private String instiuicaoEnsino; 	

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getInstiuicaoEnsino() {
        return this.instiuicaoEnsino;
    }

    public void setInstiuicaoEnsino(String instiuicaoEnsino) {
        this.instiuicaoEnsino = instiuicaoEnsino;
    }    
}
