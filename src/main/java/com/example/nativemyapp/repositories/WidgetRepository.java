package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{

}
