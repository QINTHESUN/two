package com.cp.subject.infra.basic.entity;

import lombok.Data;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午3:03
 **/
@Data
public class EsSubjectFields {

    public static final String DOC_ID = "doc_id";

    public static final String SUBJECT_ID = "subject_id";

    public static final String SUBJECT_NAME = "subject_name";

    public static final String SUBJECT_ANSWER = "subject_answer";

    public static final String SUBJECT_TYPE = "subject_type";

    public static final String CREATE_USER = "create_user";

    public static final String CREATE_TIME = "create_time";

    public static final String[] FIELD_QUERY = {
            SUBJECT_ID, SUBJECT_ANSWER, SUBJECT_TYPE, SUBJECT_NAME, CREATE_TIME, CREATE_USER, DOC_ID
    };


}
