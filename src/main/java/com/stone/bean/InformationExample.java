package com.stone.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    public InformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTitelIsNull() {
            addCriterion("titel is null");
            return (Criteria) this;
        }

        public Criteria andTitelIsNotNull() {
            addCriterion("titel is not null");
            return (Criteria) this;
        }

        public Criteria andTitelEqualTo(String value) {
            addCriterion("titel =", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelNotEqualTo(String value) {
            addCriterion("titel <>", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelGreaterThan(String value) {
            addCriterion("titel >", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelGreaterThanOrEqualTo(String value) {
            addCriterion("titel >=", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelLessThan(String value) {
            addCriterion("titel <", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelLessThanOrEqualTo(String value) {
            addCriterion("titel <=", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelLike(String value) {
            addCriterion("titel like", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelNotLike(String value) {
            addCriterion("titel not like", value, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelIn(List<String> values) {
            addCriterion("titel in", values, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelNotIn(List<String> values) {
            addCriterion("titel not in", values, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelBetween(String value1, String value2) {
            addCriterion("titel between", value1, value2, "titel");
            return (Criteria) this;
        }

        public Criteria andTitelNotBetween(String value1, String value2) {
            addCriterion("titel not between", value1, value2, "titel");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTitelUrlIsNull() {
            addCriterion("titel_url is null");
            return (Criteria) this;
        }

        public Criteria andTitelUrlIsNotNull() {
            addCriterion("titel_url is not null");
            return (Criteria) this;
        }

        public Criteria andTitelUrlEqualTo(String value) {
            addCriterion("titel_url =", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlNotEqualTo(String value) {
            addCriterion("titel_url <>", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlGreaterThan(String value) {
            addCriterion("titel_url >", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("titel_url >=", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlLessThan(String value) {
            addCriterion("titel_url <", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlLessThanOrEqualTo(String value) {
            addCriterion("titel_url <=", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlLike(String value) {
            addCriterion("titel_url like", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlNotLike(String value) {
            addCriterion("titel_url not like", value, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlIn(List<String> values) {
            addCriterion("titel_url in", values, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlNotIn(List<String> values) {
            addCriterion("titel_url not in", values, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlBetween(String value1, String value2) {
            addCriterion("titel_url between", value1, value2, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andTitelUrlNotBetween(String value1, String value2) {
            addCriterion("titel_url not between", value1, value2, "titelUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andEditIsNull() {
            addCriterion("edit is null");
            return (Criteria) this;
        }

        public Criteria andEditIsNotNull() {
            addCriterion("edit is not null");
            return (Criteria) this;
        }

        public Criteria andEditEqualTo(String value) {
            addCriterion("edit =", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotEqualTo(String value) {
            addCriterion("edit <>", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThan(String value) {
            addCriterion("edit >", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThanOrEqualTo(String value) {
            addCriterion("edit >=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThan(String value) {
            addCriterion("edit <", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThanOrEqualTo(String value) {
            addCriterion("edit <=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLike(String value) {
            addCriterion("edit like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotLike(String value) {
            addCriterion("edit not like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditIn(List<String> values) {
            addCriterion("edit in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotIn(List<String> values) {
            addCriterion("edit not in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditBetween(String value1, String value2) {
            addCriterion("edit between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotBetween(String value1, String value2) {
            addCriterion("edit not between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNull() {
            addCriterion("creat_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNotNull() {
            addCriterion("creat_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatDateEqualTo(Date value) {
            addCriterion("creat_date =", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotEqualTo(Date value) {
            addCriterion("creat_date <>", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThan(Date value) {
            addCriterion("creat_date >", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_date >=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThan(Date value) {
            addCriterion("creat_date <", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThanOrEqualTo(Date value) {
            addCriterion("creat_date <=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateIn(List<Date> values) {
            addCriterion("creat_date in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotIn(List<Date> values) {
            addCriterion("creat_date not in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateBetween(Date value1, Date value2) {
            addCriterion("creat_date between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotBetween(Date value1, Date value2) {
            addCriterion("creat_date not between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andReadCuntIsNull() {
            addCriterion("read_cunt is null");
            return (Criteria) this;
        }

        public Criteria andReadCuntIsNotNull() {
            addCriterion("read_cunt is not null");
            return (Criteria) this;
        }

        public Criteria andReadCuntEqualTo(Integer value) {
            addCriterion("read_cunt =", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntNotEqualTo(Integer value) {
            addCriterion("read_cunt <>", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntGreaterThan(Integer value) {
            addCriterion("read_cunt >", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_cunt >=", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntLessThan(Integer value) {
            addCriterion("read_cunt <", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntLessThanOrEqualTo(Integer value) {
            addCriterion("read_cunt <=", value, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntIn(List<Integer> values) {
            addCriterion("read_cunt in", values, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntNotIn(List<Integer> values) {
            addCriterion("read_cunt not in", values, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntBetween(Integer value1, Integer value2) {
            addCriterion("read_cunt between", value1, value2, "readCunt");
            return (Criteria) this;
        }

        public Criteria andReadCuntNotBetween(Integer value1, Integer value2) {
            addCriterion("read_cunt not between", value1, value2, "readCunt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}