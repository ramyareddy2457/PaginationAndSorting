package com.example.spring.data.jpa.paginationAndSorting.dto;

import com.example.spring.data.jpa.paginationAndSorting.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    int recordCount;
    T response;
}
