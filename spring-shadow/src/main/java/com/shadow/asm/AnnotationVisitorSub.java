package com.shadow.asm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.asm.Type;
import org.springframework.util.ClassUtils;


import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2715:57
 */
@Slf4j(topic = "e")
public class AnnotationVisitorSub extends AnnotationVisitor {

	List<MergedAnnotation> list;
	String sname;
	public AnnotationVisitorSub(List<MergedAnnotation> list,String sname,String descriptor){
		super(SpringAsmInfo.ASM_VERSION);
		this.list=list;
		this.sname=sname;

		String className = Type.getType(descriptor).getClassName();
		try {
			Class<?> aClass = ClassUtils.forName(className, AnnotationVisitorSub.class.getClassLoader());
			MergedAnnotation mergedAnnotation = new MergedAnnotation();
			mergedAnnotation.annotationType=aClass;
			mergedAnnotation.setSource(this.sname);
			list.add(mergedAnnotation);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(String name, Object value) {
		log.debug("xxx");
	}


	@Override
	public void visitEnd() {
		log.debug("eeee");
	}
}
