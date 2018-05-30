package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{

}
