package com.batm.cvbuilder.controller.master;

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
import com.batm.cvbuilder.service.master.ToolService;

@RestController
@RequestMapping("api")
public class ToolRestController {
    @Autowired
    ToolService toolService;

    @GetMapping("tool")
    public ResponseEntity<Object> Get() {
        List<Tool> tools = toolService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, tools);
    }

    @GetMapping("tool/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) int id) {
        Optional<Tool> tool = toolService.Get(id);
        if (tool.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, tool);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK);
    }

    @PostMapping("tool")
    public ResponseEntity<Object> Save(@RequestBody Tool tool) {
        boolean result = toolService.Save(tool);
        if (result) {
            Response.generate("data disimpan", HttpStatus.OK);
        }
        return Response.generate("data gagal disimpan", HttpStatus.OK);
    }

    @DeleteMapping("tool/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) int id) {
        boolean result = toolService.Delete(id);
        if (result) {
            Response.generate("data dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
