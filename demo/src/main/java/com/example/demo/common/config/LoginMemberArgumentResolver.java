package com.example.demo.common.config;

import com.example.demo.common.dto.LoginMember;
import com.example.demo.common.util.LoginMemberValidator;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

  private final LoginMemberValidator loginMemberValidator;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType().equals(LoginMember.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    return loginMemberValidator.checkUuid(
        ((HttpServletRequest) webRequest.getNativeRequest()).getHeader("uuid")
    );
  }
}