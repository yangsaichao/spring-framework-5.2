package com.live.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.FieldVisitor;
import org.springframework.asm.SpringAsmInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2721:37
 */
@Slf4j(topic = "e")
public class ClassParse4Asm extends ClassVisitor {

	String claSimpleName;
	MetadataShadow  metadataShadow;
	List<AnnoMetaDataShadow> list = new ArrayList<>();

	public ClassParse4Asm(){
		super(SpringAsmInfo.ASM_VERSION);
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		log.debug("visit-name=:{}",name);
		this.claSimpleName=name;
	}

	@Override
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		log.debug("xxxxxx:{}",descriptor);
		return new AnnotationVisitorParse4Asm(descriptor,list,claSimpleName);
	}



	@Override
	public void visitEnd() {
		metadataShadow = new MetadataShadow();
		metadataShadow.setClaName(claSimpleName);
		metadataShadow.setList(list);

	}

	public MetadataShadow getMetadataShadow() {
		return metadataShadow;
	}
}
