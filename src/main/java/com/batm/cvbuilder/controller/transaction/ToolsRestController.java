package com.batm.cvbuilder.controller.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batm.cvbuilder.handler.Response;
import com.batm.cvbuilder.model.master.Tool;
import com.batm.cvbuilder.model.transaction.Tools;
import com.batm.cvbuilder.service.transaction.ToolsService;

@RestController
@RequestMapping("api")
public class ToolsRestController {
    @Autowired
    ToolsService toolsService;

    @GetMapping("tools")
    public ResponseEntity<Object> Get() {
        List<Tools> tools = toolsService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, tools);
    }

    @GetMapping("tools/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Tools> tools = toolsService.Get(id);
        if (tools.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, tools);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @GetMapping("tools/my/{id}")
    public ResponseEntity<Object> GetMy(@PathVariable(required = true) int id) {
        List<Tool> tools = toolsService.getMyTools(id);
        if (!tools.isEmpty()) {
            return Response.generate("data ditemukan", HttpStatus.OK, tools);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("tools")
    public ResponseEntity<Object> Save(@RequestBody Tools tools) {
        boolean result = toolsService.Save(tools);
        if (result) {
            return Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("tools/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = toolsService.Delete(id);
        if (result) {
            return Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
