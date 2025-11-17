package com.springboot.shoppy_fullstack_app.repository_noneuse;

import com.springboot.shoppy_fullstack_app.dto.SupportDto;
import java.util.List;

public interface SupportRepository {
    List<SupportDto> findAll();
    List<SupportDto> findAll(SupportDto support);
}
