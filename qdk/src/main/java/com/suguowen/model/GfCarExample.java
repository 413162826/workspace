package com.suguowen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GfCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GfCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberIsNull() {
            addCriterion("car_brand_number is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberIsNotNull() {
            addCriterion("car_brand_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberEqualTo(String value) {
            addCriterion("car_brand_number =", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberNotEqualTo(String value) {
            addCriterion("car_brand_number <>", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberGreaterThan(String value) {
            addCriterion("car_brand_number >", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand_number >=", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberLessThan(String value) {
            addCriterion("car_brand_number <", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberLessThanOrEqualTo(String value) {
            addCriterion("car_brand_number <=", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberLike(String value) {
            addCriterion("car_brand_number like", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberNotLike(String value) {
            addCriterion("car_brand_number not like", value, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberIn(List<String> values) {
            addCriterion("car_brand_number in", values, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberNotIn(List<String> values) {
            addCriterion("car_brand_number not in", values, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberBetween(String value1, String value2) {
            addCriterion("car_brand_number between", value1, value2, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandNumberNotBetween(String value1, String value2) {
            addCriterion("car_brand_number not between", value1, value2, "carBrandNumber");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandEqualTo(String value) {
            addCriterion("car_brand =", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotEqualTo(String value) {
            addCriterion("car_brand <>", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThan(String value) {
            addCriterion("car_brand >", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand >=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThan(String value) {
            addCriterion("car_brand <", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThanOrEqualTo(String value) {
            addCriterion("car_brand <=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLike(String value) {
            addCriterion("car_brand like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotLike(String value) {
            addCriterion("car_brand not like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandIn(List<String> values) {
            addCriterion("car_brand in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotIn(List<String> values) {
            addCriterion("car_brand not in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandBetween(String value1, String value2) {
            addCriterion("car_brand between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotBetween(String value1, String value2) {
            addCriterion("car_brand not between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarVolumeIsNull() {
            addCriterion("car_volume is null");
            return (Criteria) this;
        }

        public Criteria andCarVolumeIsNotNull() {
            addCriterion("car_volume is not null");
            return (Criteria) this;
        }

        public Criteria andCarVolumeEqualTo(Integer value) {
            addCriterion("car_volume =", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeNotEqualTo(Integer value) {
            addCriterion("car_volume <>", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeGreaterThan(Integer value) {
            addCriterion("car_volume >", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_volume >=", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeLessThan(Integer value) {
            addCriterion("car_volume <", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("car_volume <=", value, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeIn(List<Integer> values) {
            addCriterion("car_volume in", values, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeNotIn(List<Integer> values) {
            addCriterion("car_volume not in", values, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeBetween(Integer value1, Integer value2) {
            addCriterion("car_volume between", value1, value2, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("car_volume not between", value1, value2, "carVolume");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontIsNull() {
            addCriterion("car_license_front is null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontIsNotNull() {
            addCriterion("car_license_front is not null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontEqualTo(String value) {
            addCriterion("car_license_front =", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontNotEqualTo(String value) {
            addCriterion("car_license_front <>", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontGreaterThan(String value) {
            addCriterion("car_license_front >", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontGreaterThanOrEqualTo(String value) {
            addCriterion("car_license_front >=", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontLessThan(String value) {
            addCriterion("car_license_front <", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontLessThanOrEqualTo(String value) {
            addCriterion("car_license_front <=", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontLike(String value) {
            addCriterion("car_license_front like", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontNotLike(String value) {
            addCriterion("car_license_front not like", value, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontIn(List<String> values) {
            addCriterion("car_license_front in", values, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontNotIn(List<String> values) {
            addCriterion("car_license_front not in", values, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontBetween(String value1, String value2) {
            addCriterion("car_license_front between", value1, value2, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseFrontNotBetween(String value1, String value2) {
            addCriterion("car_license_front not between", value1, value2, "carLicenseFront");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseIsNull() {
            addCriterion("car_license_reverse is null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseIsNotNull() {
            addCriterion("car_license_reverse is not null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseEqualTo(String value) {
            addCriterion("car_license_reverse =", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseNotEqualTo(String value) {
            addCriterion("car_license_reverse <>", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseGreaterThan(String value) {
            addCriterion("car_license_reverse >", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseGreaterThanOrEqualTo(String value) {
            addCriterion("car_license_reverse >=", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseLessThan(String value) {
            addCriterion("car_license_reverse <", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseLessThanOrEqualTo(String value) {
            addCriterion("car_license_reverse <=", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseLike(String value) {
            addCriterion("car_license_reverse like", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseNotLike(String value) {
            addCriterion("car_license_reverse not like", value, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseIn(List<String> values) {
            addCriterion("car_license_reverse in", values, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseNotIn(List<String> values) {
            addCriterion("car_license_reverse not in", values, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseBetween(String value1, String value2) {
            addCriterion("car_license_reverse between", value1, value2, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarLicenseReverseNotBetween(String value1, String value2) {
            addCriterion("car_license_reverse not between", value1, value2, "carLicenseReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronIsNull() {
            addCriterion("car_photo_fron is null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronIsNotNull() {
            addCriterion("car_photo_fron is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronEqualTo(String value) {
            addCriterion("car_photo_fron =", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronNotEqualTo(String value) {
            addCriterion("car_photo_fron <>", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronGreaterThan(String value) {
            addCriterion("car_photo_fron >", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronGreaterThanOrEqualTo(String value) {
            addCriterion("car_photo_fron >=", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronLessThan(String value) {
            addCriterion("car_photo_fron <", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronLessThanOrEqualTo(String value) {
            addCriterion("car_photo_fron <=", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronLike(String value) {
            addCriterion("car_photo_fron like", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronNotLike(String value) {
            addCriterion("car_photo_fron not like", value, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronIn(List<String> values) {
            addCriterion("car_photo_fron in", values, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronNotIn(List<String> values) {
            addCriterion("car_photo_fron not in", values, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronBetween(String value1, String value2) {
            addCriterion("car_photo_fron between", value1, value2, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFronNotBetween(String value1, String value2) {
            addCriterion("car_photo_fron not between", value1, value2, "carPhotoFron");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankIsNull() {
            addCriterion("car_photo_flank is null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankIsNotNull() {
            addCriterion("car_photo_flank is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankEqualTo(String value) {
            addCriterion("car_photo_flank =", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankNotEqualTo(String value) {
            addCriterion("car_photo_flank <>", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankGreaterThan(String value) {
            addCriterion("car_photo_flank >", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankGreaterThanOrEqualTo(String value) {
            addCriterion("car_photo_flank >=", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankLessThan(String value) {
            addCriterion("car_photo_flank <", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankLessThanOrEqualTo(String value) {
            addCriterion("car_photo_flank <=", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankLike(String value) {
            addCriterion("car_photo_flank like", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankNotLike(String value) {
            addCriterion("car_photo_flank not like", value, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankIn(List<String> values) {
            addCriterion("car_photo_flank in", values, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankNotIn(List<String> values) {
            addCriterion("car_photo_flank not in", values, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankBetween(String value1, String value2) {
            addCriterion("car_photo_flank between", value1, value2, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoFlankNotBetween(String value1, String value2) {
            addCriterion("car_photo_flank not between", value1, value2, "carPhotoFlank");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseIsNull() {
            addCriterion("car_photo_reverse is null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseIsNotNull() {
            addCriterion("car_photo_reverse is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseEqualTo(String value) {
            addCriterion("car_photo_reverse =", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseNotEqualTo(String value) {
            addCriterion("car_photo_reverse <>", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseGreaterThan(String value) {
            addCriterion("car_photo_reverse >", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseGreaterThanOrEqualTo(String value) {
            addCriterion("car_photo_reverse >=", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseLessThan(String value) {
            addCriterion("car_photo_reverse <", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseLessThanOrEqualTo(String value) {
            addCriterion("car_photo_reverse <=", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseLike(String value) {
            addCriterion("car_photo_reverse like", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseNotLike(String value) {
            addCriterion("car_photo_reverse not like", value, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseIn(List<String> values) {
            addCriterion("car_photo_reverse in", values, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseNotIn(List<String> values) {
            addCriterion("car_photo_reverse not in", values, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseBetween(String value1, String value2) {
            addCriterion("car_photo_reverse between", value1, value2, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCarPhotoReverseNotBetween(String value1, String value2) {
            addCriterion("car_photo_reverse not between", value1, value2, "carPhotoReverse");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusIsNull() {
            addCriterion("varify_status is null");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusIsNotNull() {
            addCriterion("varify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusEqualTo(String value) {
            addCriterion("varify_status =", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusNotEqualTo(String value) {
            addCriterion("varify_status <>", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusGreaterThan(String value) {
            addCriterion("varify_status >", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("varify_status >=", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusLessThan(String value) {
            addCriterion("varify_status <", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusLessThanOrEqualTo(String value) {
            addCriterion("varify_status <=", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusLike(String value) {
            addCriterion("varify_status like", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusNotLike(String value) {
            addCriterion("varify_status not like", value, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusIn(List<String> values) {
            addCriterion("varify_status in", values, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusNotIn(List<String> values) {
            addCriterion("varify_status not in", values, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusBetween(String value1, String value2) {
            addCriterion("varify_status between", value1, value2, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyStatusNotBetween(String value1, String value2) {
            addCriterion("varify_status not between", value1, value2, "varifyStatus");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeIsNull() {
            addCriterion("varify_time is null");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeIsNotNull() {
            addCriterion("varify_time is not null");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeEqualTo(Date value) {
            addCriterion("varify_time =", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeNotEqualTo(Date value) {
            addCriterion("varify_time <>", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeGreaterThan(Date value) {
            addCriterion("varify_time >", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("varify_time >=", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeLessThan(Date value) {
            addCriterion("varify_time <", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("varify_time <=", value, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeIn(List<Date> values) {
            addCriterion("varify_time in", values, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeNotIn(List<Date> values) {
            addCriterion("varify_time not in", values, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeBetween(Date value1, Date value2) {
            addCriterion("varify_time between", value1, value2, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andVarifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("varify_time not between", value1, value2, "varifyTime");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceIsNull() {
            addCriterion("car_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceIsNotNull() {
            addCriterion("car_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceEqualTo(Integer value) {
            addCriterion("car_unit_price =", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceNotEqualTo(Integer value) {
            addCriterion("car_unit_price <>", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceGreaterThan(Integer value) {
            addCriterion("car_unit_price >", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_unit_price >=", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceLessThan(Integer value) {
            addCriterion("car_unit_price <", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("car_unit_price <=", value, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceIn(List<Integer> values) {
            addCriterion("car_unit_price in", values, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceNotIn(List<Integer> values) {
            addCriterion("car_unit_price not in", values, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("car_unit_price between", value1, value2, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCarUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("car_unit_price not between", value1, value2, "carUnitPrice");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNull() {
            addCriterion("car_phone is null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNotNull() {
            addCriterion("car_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneEqualTo(String value) {
            addCriterion("car_phone =", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotEqualTo(String value) {
            addCriterion("car_phone <>", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThan(String value) {
            addCriterion("car_phone >", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("car_phone >=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThan(String value) {
            addCriterion("car_phone <", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThanOrEqualTo(String value) {
            addCriterion("car_phone <=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLike(String value) {
            addCriterion("car_phone like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotLike(String value) {
            addCriterion("car_phone not like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIn(List<String> values) {
            addCriterion("car_phone in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotIn(List<String> values) {
            addCriterion("car_phone not in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneBetween(String value1, String value2) {
            addCriterion("car_phone between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotBetween(String value1, String value2) {
            addCriterion("car_phone not between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(Integer value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(Integer value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(Integer value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(Integer value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(Integer value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<Integer> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<Integer> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(Integer value1, Integer value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
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