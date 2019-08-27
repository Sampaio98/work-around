package com.study.workaround.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CityDTO {

    private Long id;
    private String name;

    public CityDTO(){ }

    public CityDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityDTO)) return false;
        CityDTO cityDTO = (CityDTO) o;
        return Objects.equals(id, cityDTO.id) &&
                Objects.equals(name, cityDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
