package com.yimi.pospay.ui.login.model;

/**
 * @author user
 * @date 2017/4/28
 */
public class Login {
  private String appType;
  private String belongDept;
  private String belongForward;
  /** 所属公司编号 */
  private String compCode;
  private String compLongName;
  private String compName;
  /** 所属网点编号 */
  private String deptCode;
  /** 所属网点名称 */
  private String deptName;
  /** 2,3,4分别是一级网点，二级网点，三级网点; 5,6分别是一级分拨，二级分拨 */
  private Integer deptType;
  /** 3-装卸工,26-试用，27-外请，28-文员 */
  private String job;
  private String name;
  private String password;
  private String roleId;
  private String roleName;
  private Integer status;
  /** 用户编号 */
  private String userCode;
  /** 用户工号 */
  private String userWorkNum;
  private String userId;
  /** 用户名 */
  private String username;

  public String getAppType() {
    return appType;
  }

  public void setAppType(String appType) {
    this.appType = appType;
  }

  public String getBelongDept() {
    return belongDept;
  }

  public void setBelongDept(String belongDept) {
    this.belongDept = belongDept;
  }

  public String getBelongForward() {
    return belongForward;
  }

  public void setBelongForward(String belongForward) {
    this.belongForward = belongForward;
  }

  public String getCompCode() {
    return compCode;
  }

  public void setCompCode(String compCode) {
    this.compCode = compCode;
  }

  public String getCompLongName() {
    return compLongName;
  }

  public void setCompLongName(String compLongName) {
    this.compLongName = compLongName;
  }

  public String getCompName() {
    return compName;
  }

  public void setCompName(String compName) {
    this.compName = compName;
  }

  public String getDeptCode() {
    return deptCode;
  }

  public void setDeptCode(String deptCode) {
    this.deptCode = deptCode;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Integer getDeptType() {
    return deptType;
  }

  public void setDeptType(Integer deptType) {
    this.deptType = deptType;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserWorkNum() {
    return userWorkNum;
  }

  public void setUserWorkNum(String userWorkNum) {
    this.userWorkNum = userWorkNum;
  }
}
