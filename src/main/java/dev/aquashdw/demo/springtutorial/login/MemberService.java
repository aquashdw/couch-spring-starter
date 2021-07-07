package dev.aquashdw.demo.springtutorial.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(
            @Autowired
            MemberRepository memberRepository,
            @Autowired
            PasswordEncoder passwordEncoder
    ){
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Long signUp(MemberDto memberDto) {
        if(memberRepository.existsByUsername(memberDto.getUsername()))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        return memberRepository.save(new MemberEntity(
                memberDto.getUsername(),
                passwordEncoder.encode(memberDto.getPassword())
        )).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!memberRepository.existsByUsername(username))
//            throw new UsernameNotFoundException(String.format("username %s not found", username));
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        MemberEntity memberEntity = memberRepository.findByUsername(username);
        return new User(
                memberEntity.getUsername(),
                memberEntity.getPassword(),
                new ArrayList<>()
        );
    }
}
