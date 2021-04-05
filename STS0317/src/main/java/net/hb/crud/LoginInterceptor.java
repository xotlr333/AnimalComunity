package net.hb.crud;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {

   private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          //preHandle(request,response, Object)
           //������ ã�ƿ´�
         HttpSession session = request.getSession();
         String ss = (String)session.getAttribute("daum");
   
         System.out.println("LoginInterceptor ss=" + ss);
         //�α����� �ȵ� ���¿��� ��û�� ���� �� �α��� �� �� ��û�� �������� �̵��ϵ��� �ϱ� ���ؼ� ��û�� �ּҸ� ���ǿ� ������ �� �α����� �������� �� �� �ּҷ� �̵��ϵ��� �ϸ� �ȴ�.
         String uri = request.getRequestURI();
         System.out.println("request.getRequestURI()  " + uri);
           
          //������Ʈ �̸����� ã�ƿ��⶧���� �ּҸ�  http://127.0.0.1:8081/crud/~.do
         int idx = uri.lastIndexOf("/");
           uri = uri.substring(idx+1);
           
           System.out.println("idx �� :  "+idx);
         System.out.println("LoginInterceptor�μ�  uri���� "+uri);
         String query = request.getQueryString();
         System.out.println("LoginInterceptor�μ�  �Ѿ�°� " + query);
         
         //�Ķ���Ͱ� ������ ��û �ּҴ� �״�� 
         if(query==null || query.equals("null")){ query="";}
         else{ query="?"+query;}
         uri = uri + query;
         System.out.println("���� uri ��  " + uri);
      
         boolean adminCheck = false;
         //�α����� �ȵ� ��� �α��� �������� �̵�
         response.setContentType("text/html; charset=UTF-8");
           PrintWriter out = response.getWriter() ;
           
         if(ss!=null){
            adminCheck=true;   
         }else {
            out.println("<div align=center style='margin-top:30px'> <img src='./resources/images/tulips.png' width='500' height='400'>");
            out.println("<br><font color=blue size=7> <b>loging�۾�... login�۾�...</b></font> </div> <p>");
            out.append("<script>"
               + "alert('�α����� �ʿ��� �����Դϴ�');"
                + "location.href='login.do';"
               + "</script>").flush();
            adminCheck=false;
         }
         return adminCheck;
   }//end

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)throws Exception {
      //��Ʈ�ѷ��� �޼ҵ� ������ , ȭ��ó���� ó�� 
      //afterCompletion(request,response, Object, Exception)
        logger.info("=======================afterCompletion start========================");
      logger.info("=======================afterCompletion end=========================");
   }//end
         
   
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)throws Exception {
      //postHandle(request,response, Object, ModelAndView)
      logger.info("=======================postHandle start======================");
      logger.info("=======================postHandle end=========================");   
   }//end

}//LoginInterceptor END