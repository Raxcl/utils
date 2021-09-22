package my.util.four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//新增可视化界面，让工具使用更加便捷
public class ViewReplace extends JFrame implements ActionListener {
    JFrame mainframe;
    JPanel panel;
    //创建相关的标签和文本框
    //需求规则
    JLabel inputReglx1 = new JLabel("请输入需求字符串规则:");
    JLabel inputNeedRuleTitleLeft = new JLabel("左:");
    JLabel inputNeedRuleTitleRight = new JLabel("右:");
    JTextField inputNeedRuleLeftTxt = new JTextField();
    JTextField inputNeedRuleRightTxt = new JTextField();
    //替换规则
    JLabel inputReglx2 = new JLabel("请输入替换字符串规则:");
    JLabel inputReplaceRuleTitleLeft = new JLabel("左:");
    JLabel inputReplaceRuleTitleRight = new JLabel("右:");
    JTextField inputReplaceRuleLeftTxt = new JTextField();
    JTextField inputReplaceRuleRightTxt = new JTextField();
    //输入需求内容
    JLabel inputNeed = new JLabel("请输入需要提取文本内容:");
    JTextArea inputNeedTxt = new JTextArea();
    //输出替换内容
    JLabel inputReplace = new JLabel("请输入需要被替换的内容:");
    JTextArea outputReplaceTxt = new JTextArea();
    //返回结果内容
    JLabel outResult = new JLabel("结果:");
    JTextArea outResultTxt = new JTextArea();
    //执行脚本按钮
    JButton startButton = new JButton("开始替换");

    //方法入口
    public void viewWin(){
        mainframe = new JFrame("raxcl---文本替换工具");
        mainframe.setSize(575,550);
        //设置默认关闭操作
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);

        //初始化面板
        initPanel();
        //展示面板
        mainframe.add(panel);
        mainframe.setVisible(true);
    }

    public void initPanel() {
        this.panel = new JPanel();
        panel.setLayout(null);
        //规则界面
        //需求规则
        inputReglx1.setBounds(10,20,320,25);
        this.panel.add(inputReglx1);
        //需求左
        inputNeedRuleTitleLeft.setBounds(10,50,25,25);
        this.panel.add(inputNeedRuleTitleLeft);
        inputNeedRuleLeftTxt.setBounds(35,50,75,25);
        this.panel.add(inputNeedRuleLeftTxt);
        //需求右
        inputNeedRuleTitleRight.setBounds(150,50,25,25);
        this.panel.add(inputNeedRuleTitleRight);
        inputNeedRuleRightTxt.setBounds(175,50,75,25);
        this.panel.add(inputNeedRuleRightTxt);

        //替换规则
        inputReglx2.setBounds(300,20,320,25);
        this.panel.add(inputReglx2);
        //替换左
        inputReplaceRuleTitleLeft.setBounds(300,50,25,25);
        this.panel.add(inputReplaceRuleTitleLeft);
        inputReplaceRuleLeftTxt.setBounds(325,50,75,25);
        this.panel.add(inputReplaceRuleLeftTxt);
        //替换右
        inputReplaceRuleTitleRight.setBounds(440,50,25,25);
        this.panel.add(inputReplaceRuleTitleRight);
        inputReplaceRuleRightTxt.setBounds(465,50,75,25);
        this.panel.add(inputReplaceRuleRightTxt);
        //设置默认规则
        //需求规则
        inputNeedRuleLeftTxt.setText("model.");
        inputNeedRuleRightTxt.setText("`");
        //替换规则
        inputReplaceRuleLeftTxt.setText("name: '");
        inputReplaceRuleRightTxt.setText("'");
        //输入文本框1
        inputNeed.setBounds(10,85,320,25);
        this.panel.add(inputNeed);
        inputNeedTxt.setBounds(10,115,200,100);
        this.panel.add(inputNeedTxt);
        //输入文本框2
        inputReplace.setBounds(300,85,320,25);
        this.panel.add(inputReplace);
        outputReplaceTxt.setBounds(300,115,200,100);
        this.panel.add(outputReplaceTxt);
        //返回结果内容
        outResult.setBounds(10,225,320,25);
        this.panel.add(outResult);
        outResultTxt.setBounds(10,255,500,100);
        this.panel.add(outResultTxt);
        //开始执行替换脚本
        startButton.setBounds(200,380,150,100);
        this.panel.add(startButton);
        //增加动作监听
        startButton.addActionListener(this);
    }

    //单击动作触发方法
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == startButton){
            //获取需求规则
            String ruleNeedLeft = inputNeedRuleLeftTxt.getText();
            String ruleNeedRight = inputNeedRuleRightTxt.getText();
            //获取替换规则
            String ruleReplaceLeft = inputReplaceRuleLeftTxt.getText();
            String ruleReplaceRight = inputReplaceRuleRightTxt.getText();
            //获取输入文本
            String needTxt = inputNeedTxt.getText();
            String replaceTxt = outputReplaceTxt.getText();
            //执行替换方法
            ReplaceWithView replaceWithView = new ReplaceWithView();
            String result = replaceWithView.startReplace(ruleNeedLeft,ruleNeedRight,ruleReplaceLeft,ruleReplaceRight,needTxt,replaceTxt);
            //返回结果到页面
            outResultTxt.setText(result);
        }
    }

    public static void main(String[] args) {
        ViewReplace viewReplace = new ViewReplace();
        viewReplace.viewWin();
    }

}
