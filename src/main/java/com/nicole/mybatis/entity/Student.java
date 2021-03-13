package com.nicole.mybatis.entity;


public class Student {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String name;
    private String qqNumber;
    private String major;
    private String estimatedTimeEnrollment;
    private String school;
    private String studentId;
    private String logLink;
    private String mentor;
    private String wishes;
    private String recommendedFrom;


    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEstimatedTimeEnrollment() {
        return estimatedTimeEnrollment;
    }

    public void setEstimatedTimeEnrollment(String estimatedTimeEnrollment) {
        this.estimatedTimeEnrollment = estimatedTimeEnrollment;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLogLink() {
        return logLink;
    }

    public void setLogLink(String logLink) {
        this.logLink = logLink;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public String getRecommendedFrom() {
        return recommendedFrom;
    }

    public void setRecommendedFrom(String recommendedFrom) {
        this.recommendedFrom = recommendedFrom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", createAt=" + createAt +
                '}';
    }
}
