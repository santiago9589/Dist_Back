package com.app.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

    private String idProduct;
    private String nombre;
    private String descripcion;
    private byte[] image;
   private String categoria;

}
