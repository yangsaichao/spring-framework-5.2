package com.live.util;

import com.shadow.asm.AnnotationVisitorSub;
import com.shadow.asm.MergedAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.asm.Type;
import org.springframework.util.ClassUtils;

import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2722:04
 */
@Slf4j(topic = "e")
public class AnnotationVisitorParse4Asm extends AnnotationVisitor {
	List<MergedAnnotation> list;
	String sourceName;
	public AnnotationVisitorParse4Asm(String descriptor, List list,String sourceName){
		super(SpringAsmInfo.ASM_VERSION);
		this.list=list;
		this.sourceName=sourceName;

		String className = Type.getType(descriptor).getClassName();
		try {
			Class<?> aClass = ClassUtils.forName(className, AnnotationVisitorSub.class.getClassLoader());

			AnnoMetaDataShadow annoMetaDataShadow = new AnnoMetaDataShadow();
			annoMetaDataShadow.setAnnotationType(aClass);

			annoMetaDataShadow.setSource(sourceName);

			list.add(annoMetaDataShadow);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void visit(String name, Object value) {
		log.debug("---------------------");
	}

	@Override
	public void visitEnd() {

	}
}
