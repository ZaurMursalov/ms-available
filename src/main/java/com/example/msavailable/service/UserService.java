package com.example.msavailable.service;

import com.example.msavailable.entity.Role;
import com.example.msavailable.entity.UserEntity;
import com.example.msavailable.mapper.UserMapper;
import com.example.msavailable.model.dto.GenericResponse;
import com.example.msavailable.model.dto.UserDto;
import com.example.msavailable.model.request.UserRequest;
import com.example.msavailable.repository.RoleRepository;
import com.example.msavailable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public ResponseEntity register(UserRequest request) {
        log.info("Register.start phone: {}", request.getPhoneNumber());
        String phoneNumber = request.getPhoneNumber();

        if (phoneNumber.length() != 12) {
            throw new RuntimeException("Simvol 12  olmalidir");
        }
        userRepository.findByPhoneNumber(request.getPhoneNumber()).ifPresent(userDto -> {
            throw new RuntimeException("Bu Shexs artiq qeydiyyatdan kecib !");
        });

        String password = passwordEncoder.encode(request.getPassword());
        UserEntity userEntity = new UserEntity();
        Role role = roleRepository.findById(request.getRoleDto().getId())
                .orElseThrow(() -> new RuntimeException("Rolu tapmaq mümkün olmadı!"));

        if (role.getName().equals("PHYSICAL")){
          UserMapper.mapToUserEntityPhysical(request);
        }
        else if (role.getName().equals("COMPANY")){
         UserMapper.mapToUserEntityCompany(request);
        }
        else {
            return ResponseEntity.ok(new GenericResponse<>("Gonderdiyiniz role tapilmadi",null));
        }
        userEntity.setPassword(password);
        userEntity.setPhoneNumber(phoneNumber);

        userRepository.save(userEntity);


        return ResponseEntity.ok(new GenericResponse<>("İstifadəçi uğurla qeydiyyatdan keçdi", userEntity));

    }

    //update ucun

    public ResponseEntity<?>updateUser(Long id, UserRequest userRequest){
        log.info("UpdateUser.start id:{}",id);
        var userEntity=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Istifadeci Tapilmadi!!!"));

        Role role=roleRepository.findById(userRequest.getRoleDto().getId())
                .orElseThrow(()->new RuntimeException("Role tapmaq mumkun olmadi!!!"));

        if (role.getName().equals("PHYSICAL")){
            UserMapper.mapToUserEntityPhysical(userRequest);
        }
        else if (role.getName().equals("COMPANY")) {
          UserMapper.mapToUserEntityCompany(userRequest);
        }
        else {
            return ResponseEntity.ok(new GenericResponse<>("Göndərdiyiniz rol tapılmadı", null));
        }

        if (userRequest.getPassword()!=null&& userRequest.getPassword().isEmpty()){
            String encodedPassword=passwordEncoder.encode(userRequest.getPassword());
            userEntity.setPassword(encodedPassword);
        }
        userRepository.save(userEntity);

return ResponseEntity.ok(new GenericResponse<>("İstifadəçi məlumatları uğurla yeniləndi", userEntity));

    }

    //yalniz Sifreni deyismek istese user
    public ResponseEntity<?>updatePassword(Long id, String password){
        var user=fetchExistsById(id);
        if (password!=null && !password.isEmpty()){
            String passwordEncoded=passwordEncoder.encode(password);
            user.setPassword(passwordEncoded);
            userRepository.save(user);
            return ResponseEntity.ok(new GenericResponse<>("Şifrə uğurla yeniləndi", null));

        }
        return ResponseEntity.ok(new GenericResponse<>("Axtardiginiz melumat tapilmadi",null));

    }








    private  UserEntity fetchExistsById(Long id){
       return userRepository.findById(id).orElseThrow(()->
                new RuntimeException("Istfidaci Tapilmadi!!!"));
    }

}






