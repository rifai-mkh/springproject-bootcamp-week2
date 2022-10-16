package com.rapidtech.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;


@NoArgsConstructor

public enum Grade {
    A, B, C, D, F;
}
