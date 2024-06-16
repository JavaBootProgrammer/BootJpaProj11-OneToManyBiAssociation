package com.nt.service;

public interface ICompanyMgmtService {
    public String saveDataUsingParent();
    public   String   saveDataUsingChild();
    public    void    loadDataUsingParent();
    public   void   loadDataUsingChild();
    public   String    deleteDataUsingParent(Integer parentId);
    public   String   deleteDataUsingChild(int  childId);
    public  String   addNewChildTotheExistingChildsOfAParent(int parentId);
}
