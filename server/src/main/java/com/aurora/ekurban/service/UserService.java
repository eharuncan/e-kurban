package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.exception.UserNotFoundException;
import com.aurora.ekurban.repository.UserReposiory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserReposiory userReposiory;

    /**
     * @param userReposiory constructor ile repository inject ediliyor
     */
    public UserService(UserReposiory userReposiory) {
        this.userReposiory = userReposiory;
    }

    /**
     * @param eposta Database de aranılacak olan eposta/kullanıcı adı alanı
     * @return repositoryde girilen eposta ile kayırlı olan tüm alanları liste halinde geri döndürür
     */
    public List<User> findUser(String eposta) {
        return userReposiory.findUserByEposta(eposta);
    }

    /**
     * @param _user Kullanıcının girdiği eposta/kullanıcı adı ve şifreyi içeren domain sınıfımız
     * @return Kullanıcı database de kayıtlı ise true, kayıtlı değilse false değeri döner
     */
    public Optional<User> validate(User _user) {
        Optional<User> user = Optional.ofNullable(this.findUser(_user.getEposta()).stream().findFirst()
                .orElseThrow(() -> new UserNotFoundException(_user.getEposta())));

        if (user.isPresent()) {
            String passwordInDatabase = user.get().getSifre();
            String userEnteredPassword = _user.getSifre();
            if (passwordInDatabase.equals(userEnteredPassword)) {
                return user;
            }
        }

        throw new UserNotFoundException(_user.getEposta());
    }

    public Boolean logout() {
        return true;
    }
}
