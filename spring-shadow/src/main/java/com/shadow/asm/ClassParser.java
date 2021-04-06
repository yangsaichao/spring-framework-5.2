package com.shadow.asm;


import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2714:57
 */

@Slf4j(topic = "e")
public class ClassParser extends ClassVisitor {
	List<MergedAnnotation> list = new ArrayList<>();
	ShadowMetaData data = new ShadowMetaData();
	String name;
	public ClassParser(ClassLoader classLoader) {
		super(SpringAsmInfo.ASM_VERSION);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		log.debug("descriptor:{}",descriptor);
		return new AnnotationVisitorSub(list,name,descriptor);
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		log.debug("name:{}",name);
		this.name=name;
	}

	@Override
	public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
		return super.visitField(access, name, descriptor, signature, value);
	}

	@Override
	public void visitEnd() {
		data.setList(list);
	}

	public ShadowMetaData getData() {
		return data;
	}
}
