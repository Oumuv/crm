package com.oumuv.core;

import java.io.File;
import java.util.TimerTask;

/**
 * 文件删除任务
 * @author Administrator
 *
 */
public class DeleteFileTimerTask extends TimerTask{
	
	private File file;
	
	public DeleteFileTimerTask(File file) {
		super();
		this.file = file;
	}

	@Override
	public void run() {
		deleteFilr(file);
	}

	/**
	 * 文件删除（包括空文件夹）
	 * @param file
	 */
	private void deleteFilr(File file){
		if(file.exists()){
			File parentFile = file.getParentFile();
			if(file.isFile()){
				boolean delete = file.delete();
				if(delete){
					System.out.println(file.getName()+"删除成功");
					deleteFilr(parentFile);
				}else{
					System.out.println(file.getName()+"删除失败，文件被占用");
				}
			}else{
				String[] list = file.list();
				if(list.length<1){//如果是空目录则删除
					boolean delete = file.delete();
					if(delete){
						System.out.println(file.getName()+"删除成功");
						deleteFilr(parentFile);
					}else{
						System.out.println(file.getName()+"删除失败，文件被占用");
					}
				}
			}
		}
	}
}
