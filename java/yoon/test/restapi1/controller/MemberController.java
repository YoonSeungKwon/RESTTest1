package yoon.test.restapi1.controller;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoon.test.restapi1.dto.MemberDto;
import yoon.test.restapi1.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login/{id}")
    public ResponseEntity<String> login(@PathVariable Long id){
        MemberDto dto = memberService.find(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/join")
    public MemberDto login(@RequestBody MemberDto dto){
        System.out.println(dto.getName());
        System.out.println(dto.getPassword());
        memberService.join(dto);
        return dto;
    }

    @PutMapping("/update/{id}")
    public MemberDto update(@PathVariable Long id,
                       @RequestBody MemberDto dto){
        System.out.println(dto);
        MemberDto tempDto = memberService.update(id, dto);
        return tempDto;
    }

    @DeleteMapping("/unlink/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
