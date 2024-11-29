package com.mftplus.office.model.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@MappedSuperclass
public class Base implements Serializable {

    @JsonbTransient
    private boolean editing = false;

    @JsonbTransient
    private boolean deleted = false;

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }

    private class Gson {
        public String toJson(Base base) {
            return null;
        }
    }
}
