package com.example.task_manager.util;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        EntityTransaction trx = manager.getTransaction();
        boolean creator = false;

        try{
            if(!trx.isActive()) {
                trx.begin();
                trx.rollback();
                trx.begin();
                creator = true;
            }
            return ctx.proceed();
        } catch(Exception e) {
            if (trx != null && creator){
                trx.rollback();
            }
            throw e;
        } finally {
            if(trx != null && trx.isActive() && creator){
                trx.commit();
            }
        }
    }
}
