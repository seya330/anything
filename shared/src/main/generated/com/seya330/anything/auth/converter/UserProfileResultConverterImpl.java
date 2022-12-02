package com.seya330.anything.auth.converter;

import com.seya330.anything.auth.dto.UserProfileResult;
import com.seya330.anything.auth.entity.UserProfile;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T11:46:55+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_282 (AdoptOpenJDK)"
)
@Component
public class UserProfileResultConverterImpl implements UserProfileResultConverter {

    @Override
    public UserProfileResult convert(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UserProfileResult.UserProfileResultBuilder userProfileResult = UserProfileResult.builder();

        if ( userProfile.getSeq() != null ) {
            userProfileResult.seq( userProfile.getSeq() );
        }
        userProfileResult.email( userProfile.getEmail() );
        userProfileResult.name( userProfile.getName() );
        userProfileResult.loginType( userProfile.getLoginType() );

        return userProfileResult.build();
    }
}
