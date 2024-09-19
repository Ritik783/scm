package com.scm.RestController;


import com.scm.Entities.ScmEntity;
import com.scm.Repo.ScmRemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ScMController {

    @Autowired
    private ScmRemp scmRemp;

    @PostMapping("/demo")
    public String print(@RequestBody ScmEntity scmEntity) {
        scmEntity.setName(scmEntity.getName());
        scmEntity.setLast(scmEntity.getLast());

        scmRemp.save(scmEntity);
        return "success";
    }
}

