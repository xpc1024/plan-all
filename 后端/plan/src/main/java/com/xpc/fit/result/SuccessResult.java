package com.xpc.fit.result;

public class SuccessResult extends Result{
   private Object object;
   public SuccessResult(){
      super.code = 200;
      super.msg = "success";
   }

   public SuccessResult(Object o){
      super.code = 200;
      super.msg = "success";
      super.data = o;
   }
}
